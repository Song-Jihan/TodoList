package todoList;

import java.util.ArrayList;

public class TodoListRepository{
	
	static ArrayList<TodoListDTO> todoList = new ArrayList<>();
	static ArrayList<TodoCategoryDTO> categoryList = new ArrayList<>();
	
	public ArrayList<TodoCategoryDTO> findAllCategory(){
		return categoryList;
	}
	
	public boolean categoryDuplicationCheck(String categoryName){
		boolean result=false;
		for(TodoCategoryDTO category:categoryList){
			if(category.getCategoryName().equals(categoryName)){
				result=true;
				break;
			}
		}
		return result;
	}
	
	public String findCategoryNameByCategoryId(Long categoryId){
		for(TodoCategoryDTO category:categoryList){
			if(category.getCategoryId().equals(categoryId)){
				return category.getCategoryName();
			}
		}
		return null;
	}
	
	public boolean saveTodo(TodoListDTO newTodo){
		return todoList.add(newTodo);
	}
	
	public boolean saveCategory(TodoCategoryDTO newCategory){
		return categoryList.add(newCategory);
	}
	
	public findTodoList(){
		
	}
		
	public boolean updateCategory(Long categoryId, String categoryName){
		boolean result=false;
		String beforeCategoryName="";
		for(TodoCategoryDTO category:categoryList){
			if(category.getCategoryId().equals(categoryId)){
				beforeCategoryName=category.getCategoryName();
				result=true;
				break;
			}
		}
		
		if(!result){
			return result;
		}
		
		for(TodoListDTO todo:todoList){
			if(todo.getTodoCategory().equals(beforeCategoryName)){
				todo.setTodoCategory(categoryName);
			}
		}
		
		return result;
	}
}