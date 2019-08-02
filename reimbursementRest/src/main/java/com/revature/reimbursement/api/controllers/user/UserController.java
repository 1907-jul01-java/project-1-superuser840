package com.revature.reimbursement.api.controllers.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.reimbursement.api.ConnectionUtil;
import com.revature.reimbursement.api.domain.User;
import com.revature.reimbursement.api.domain.UserService;
import com.revature.reimbursement.api.daos.UserDao;

/**
 * UserController
 * 
 */
@Path(value = "users")
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsersJSON() {
		List<User> users = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			UserDao dao = new UserDao(connection);
			UserService service = new UserService(dao);
			users = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
    }

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
    public void insertUser(@FormParam("id") String id, @FormParam("email") String email, @FormParam("password") String password,
     @FormParam("firstname") String firstName, @FormParam("lastname") String lastName, @FormParam("usertype") String userType,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			UserDao dao = new UserDao(connection);
			UserService service = new UserService(dao);
			service.insert(new User(0, email, password, firstName, lastName, userType));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/User-api");
	}
}