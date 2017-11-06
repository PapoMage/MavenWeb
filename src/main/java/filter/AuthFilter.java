package filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.AuthMb;

@WebFilter(filterName = "authFilter", urlPatterns = "*.xhtml")
public class AuthFilter implements Filter {

	@Inject
	private AuthMb authMb;

	@Override
	public void destroy() {
		// TODO Auto-generated metho d stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		if ((request.getRequestURI().equals("/home.xhtml") && !authMb.isLogged())
				|| (request.getRequestURI().equals("/posts.xhtml") && !authMb.isLogged())
				|| (request.getRequestURI().equals("/perfil.xhtml") && !authMb.isLogged())
				|| (request.getRequestURI().equals("/users.xhtml") && !authMb.isLogged())) {
			response.sendRedirect("index.xhtml");
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
