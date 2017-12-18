package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import model.ImageUser;
import model.User;

@Stateless
public class ImageUserController {

	@PersistenceContext
	private EntityManager em;

	private static final File UPLOAD_DIR = new File("C:/storage/images/user/");

	private static final char[] CHARS = "abcdefghijklmnopqrstwxyz0123456789".toCharArray();

	private static final int PATH_LENGTH = 10;

	private final Random rnd = new Random();

	public boolean existFile(String path) {
		return Files.exists(new File(UPLOAD_DIR, path).toPath());
	}

	public InputStream read(String path) throws FileNotFoundException {
		return new FileInputStream(new File(UPLOAD_DIR, path));
	}

	private String generatePath() {
		char[] rndChars = new char[PATH_LENGTH];
		for (int i = 0; i < PATH_LENGTH; i++) {
			rndChars[i] = CHARS[rnd.nextInt(CHARS.length)];
		}
		String rndPath = new String(rndChars);
		if (existFile(rndPath)) {
			return generatePath();
		} else {
			return rndPath;
		}
	}

	public ImageUser upload(Part file) throws IOException {
		if (!UPLOAD_DIR.exists()) {
			UPLOAD_DIR.mkdirs();
		}
		ImageUser img = new ImageUser();
		String path = generatePath();
		img.setPath(path);
		img.setSize(file.getSize());
		img.setType(file.getContentType());
		em.persist(img);
		Files.copy(file.getInputStream(), new File(UPLOAD_DIR, path).toPath());
		return img;
	}

	public ImageUser findByPath(String path) {
		String jpql = "Select i From ImageUser i Where i.path = :path";
		TypedQuery<ImageUser> q = em.createQuery(jpql, ImageUser.class);
		q.setParameter("path", path);
		return q.getSingleResult();
	}
	
	public void updateImage(User user,ImageUser img) {
		
		user.setImage(img);
		em.merge(user);
	}

}