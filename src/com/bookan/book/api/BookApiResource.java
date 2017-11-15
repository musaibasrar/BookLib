package com.bookan.book.api;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookan.book.domain.BooksDetails;
import com.bookan.book.domain.User;
import com.bookan.book.service.BooksDetailsService;
import com.bookan.book.service.UserService;
import com.google.gson.Gson;

@Path("/entry")
@Component

public class BookApiResource {

	@Autowired
	BooksDetailsService booksDetailsService;

	@Autowired
	UserService userService;

	@Autowired
	BooksDetails booksDetails;

	@RolesAllowed("authenticate")
	@Path("/authenticate")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String authenticateUser(final String jsonRequestBody) {
		boolean result = false;
		System.out.println("Title of the book " + jsonRequestBody);
		System.out.println("Second Success");
		Gson g = new Gson();
		User user = g.fromJson(jsonRequestBody, User.class);

		String authResult = userService.userAuthenticate(user);

		return authResult = g.toJson(authResult);
	}

	@Path("/add")
	// @PUT
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON })
	public String addBook(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("title") String title) {

		String result = "true";
		System.out.println("Title of the book is " + title);

		String encodedFile = null;
		byte[] bytesEncoded1 = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int reads = uploadedInputStream.read();
			while (reads != -1) {
				baos.write(reads);
				reads = uploadedInputStream.read();
			}
			byte[] Byte = baos.toByteArray();
			bytesEncoded1 = Base64.encodeBase64(Byte);
		} catch (Exception e) {
			e.printStackTrace();
		}

		encodedFile = new String(bytesEncoded1);
		booksDetails.setUserid(3);
		booksDetails.setISBN("123");
		booksDetails.setTitle(title);
		booksDetails.setLanguage("English");
		booksDetails.setBookimage(encodedFile);

		booksDetailsService.addBooks(booksDetails);
		System.out.println("book added successfully");
		return result;

	}

	@Path("/getAllBooks")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getAllBooksDetails() {
		System.out.println("inside get book details");
		List<BooksDetails> bookDetails = new ArrayList<BooksDetails>();

		bookDetails = booksDetailsService.getAllBooks();
		Gson g = new Gson();
		String bookDetailsString = g.toJson(bookDetails);

		return bookDetailsString;
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public String deleteBook(@PathParam("id") int id) {

		String result = "success";
		result = booksDetailsService.deleteBook(id);
		System.out.println("book deleted successfully");
		return result;

	}

	@Path("/getbookdetails/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public BooksDetails getBookDetails(@PathParam("id") int id) {

		BooksDetails bookDetails = booksDetailsService.getBookdetails(id);
		System.out.println("Book details " + bookDetails);
		return bookDetails;

	}

	@Path("/updatebookdetails/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
    public String updateBookDetails(@FormDataParam("file") InputStream uploadedInputStream,
    		@FormDataParam("title") String title){
		
		String result="fail";
		System.out.println("Title of the book is "+title);
		String encodedFile = null;
		byte[] bytesEncoded1 = null;
		
		if(null != uploadedInputStream){
			
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int reads = uploadedInputStream.read();
			
			while(reads != -1){ 
			baos.write(reads); 
			reads = uploadedInputStream.read(); 
			}
			
		byte[] Byte= baos.toByteArray();
		bytesEncoded1 = Base64.encodeBase64(Byte);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}else{
			encodedFile="take the hidden value from the form";
		}
		
		encodedFile = new String(bytesEncoded1);
		booksDetails.setUserid(3);
		booksDetails.setISBN("123");
		booksDetails.setTitle(title);
		booksDetails.setLanguage("English");
		booksDetails.setBookimage(encodedFile);
		
		booksDetailsService.updateBookDetails(booksDetails);
		
		return result;
	
	}

	@GET
	@Consumes({ MediaType.APPLICATION_JSON })

	public boolean bookDetails(@QueryParam("name") final String name, @QueryParam("author") final String author,
			@QueryParam("description") final String description, @QueryParam("publisher") final String publisher) {
		boolean result = false;
		System.out.println("Title of the book " + name);
		System.out.println("First Success");

		return result;
	}

}
