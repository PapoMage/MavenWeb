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

import model.Image;

@Stateless
public class ImageController {

	@PersistenceContext
	private EntityManager em;

	private static final File UPLOAD_DIR = new File("/home/techblog/images/");

	private static final char[] CHARS = "abcdefghijklmnopqrstwxyz0123456789 -_@()".toCharArray();

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

	public Image upload(Part file) throws IOException {
		if (!UPLOAD_DIR.exists()) {
			UPLOAD_DIR.mkdirs();
		}
		Image img = new Image();
		String path = generatePath();
		img.setPath(path);
		img.setSize(file.getSize());
		img.setType(file.getContentType());
		em.persist(img);
		Files.copy(file.getInputStream(), new File(UPLOAD_DIR, path).toPath());
		return img;
	}

	public Image findByPath(String path) {
		String jpql = "Select i From Image i Where i.path = :path";
		TypedQuery<Image> q = em.createQuery(jpql, Image.class);
		q.setParameter("path", path);
		return q.getSingleResult();

	}

}