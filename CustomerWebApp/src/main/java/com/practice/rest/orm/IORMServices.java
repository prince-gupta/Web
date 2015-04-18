package com.practice.rest.orm;

import java.util.List;

public interface IORMServices<T> {
	
	public T save(T t);
	
	public List<T> get();
	
	public T get(Integer id);
	
	public boolean delete(T t);

}
