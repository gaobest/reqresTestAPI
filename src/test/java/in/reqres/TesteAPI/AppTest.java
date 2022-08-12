package in.reqres.TesteAPI;

/*   REST-Assured, Junit, Maven, JAVA   */

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class AppTest extends MassaDeDados {

	@BeforeClass
	public static void urlbase() {
		RestAssured.baseURI = "https://reqres.in/api/";
	}

	@Test
	public void totalUsers() {
		Response response = given().contentType("application/json").pathParam("page", page)
				.pathParam("per_page", per_page).when().get(urlTotalUsers);
		response.then().statusCode(200);

		int total = response.jsonPath().getInt("total");
		totalUsers = total;
		System.out.println("Total users => " + total);
	}

	@Test
	public void listUsers() {
		page = 1;
		totalUsers();
		per_page = totalUsers;

		Response response = given().contentType("application/json").pathParam("page", page)
				.pathParam("per_page", per_page).when().get(urlListUsers);
		response.then().statusCode(200);

		System.out.println("RETORNO Lista Usuarios => " + response.body().asString());

	}

	@Test
	public void singleUser() {
		Response response = given().contentType("application/json").pathParam("id", id).when().get(urlSingleUser);
		response.then().statusCode(200);

		System.out.println("RETORNO Single USER => " + response.body().asString());
	}

	@Test
	public void singleUserNotFound() {
		Response response = given().contentType("application/json").pathParam("id", id).when()
				.get(urlSingleUserNotFound);
		response.then().statusCode(404);
		System.out.println("RETORNO USER NOT found => " + response.body().asString());

	}

	@Test
	public void create() {
		Response response = given().contentType("application/json").pathParam("id", id).when().post(urlCreate);

		response.then().statusCode(201);

		System.out.println("POST CREATE => " + response.body().asString());
		String id = response.jsonPath().getString("id");
		System.out.println("ID CREATED => " + id);
	}

	@Test
	public void PUTUpdate() {
		Response response = given().contentType("application/json").when().put(urlPUTUpdate);

		response.then().statusCode(200);

		System.out.println("PUT UPDATE => " + response.body().asString());

	}

	@Test
	public void delete() {
		Response response = given().contentType("application/json").when().delete(urlDelete);

		response.then().statusCode(204);

		System.out.println("DELETE => " + response.body().asString());
	}

	@Test
	public void loginSuccessful() {
		Response response = given().contentType("application/json").body(corpoLoginSuccessful).when()
				.post(urlLoginSuccessful);

		response.then().statusCode(200);

		System.out.println("Login Successful => " + response.body().asString());
	}

	@Test
	public void loginUnSuccessful() {

		Response response = given().contentType("application/json").body(corpoLoginUnsuccessful).when()
				.post(urlLoginUnsuccessful);

		response.then().statusCode(400);

		System.out.println("Login Unsuccessful => " + response.body().asString());
	}
}
