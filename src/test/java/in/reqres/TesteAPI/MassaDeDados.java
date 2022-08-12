package in.reqres.TesteAPI;

public class MassaDeDados {
	  int id = 12;  //Single User Id to collect
	  int page = 1;
	  int per_page = 6;
	  
	  int users = 23;  
	  int totalUsers = 0; //Variable initialization
	  
	  String email = "eve.holt@reqres.in"; //User to login
	  String password = "cityslicka";		//Password to login
	  
	  String urlTotalUsers = "users?page={page}&per_page={per_page}";
	  
	  String urlListUsers = "users?page={page}&per_page={per_page}";
	  
	  String urlSingleUser = "users/{id}";
	  String urlSingleUserNotFound = "users/{id}";
	  String urlCreate = "users/{id}";
	  String urlPUTUpdate = "users/2";
	  String urlDelete = "users/2";
	  
	  String urlLoginSuccessful = "login";
	  String corpoLoginSuccessful = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";
		
	  String urlLoginUnsuccessful = "login";
	  String corpoLoginUnsuccessful = "{\"email\": \"eve.holt@reqres.in\"}";
}
