package com.revature.revabooks.models;

import java.util.List;

public class Book {
	private Integer id;
	private String isbn;
	private String title;
	private List<Genre> genre;
	private Integer stockCount;
}
