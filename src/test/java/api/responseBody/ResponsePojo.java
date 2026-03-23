package api.responseBody;

public class ResponsePojo {
	
	public ResponsePojo() {
		
	}
	
	/*
	 * 
	 *  "id": 7964648,
    "name": "granville.nitzsche",
    "email": "henry.turcotte@yahoo.com",
    "gender": "male",
    "status": "active"
	 */
	//require fields
	private int id ;
	private String name;
	private String email;
	private String gender;
	private String status;
	//constructor 
	public ResponsePojo(int id, String name, String email, String gender, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}
	//set and get methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	

}
