package todoList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

public class TodoListRepository{
	
	static ArrayList<TodoListDTO> todoList = new ArrayList<>();
	static ArrayList<TodoCategoryDTO> categoryList = new ArrayList<>();
	
	static String completeCategory="완료한 할 일 목록";
	static String defaultCategory="내 할 일 목록";

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
	
	public ArrayList<TodoListDTO> findIncompletedTodoList(){
		ArrayList<TodoListDTO> incompletedTodoList = new ArrayList<>();
		for(TodoListDTO todo:todoList){
			if(todo.getTodoCategory().equals(completeCategory)){
				continue;
			}
			incompletedTodoList.add(todo);
			Collections.sort(incompletedTodoList,new Comparator<TodoListDTO>() {
				@Override
				public int compare(TodoListDTO o1, TodoListDTO o2){
					return (o1.getTodoDeadline().compareTo(o2.getTodoDeadline()));
				} 
			});
		}
		return incompletedTodoList;
	}
		
	public ArrayList<TodoListDTO> findCompletedTodoList(){
		ArrayList<TodoListDTO> completedTodoList = new ArrayList<>();
		for(TodoListDTO todo:todoList){
			if(!todo.getTodoCategory().equals(completeCategory)){
				continue;
			}
			completedTodoList.add(todo);
			Collections.sort(completedTodoList,new Comparator<TodoListDTO>() {
				@Override
				public int compare(TodoListDTO o1, TodoListDTO o2){
					return (o1.getTodoDeadline().compareTo(o2.getTodoDeadline()));
				} 
			});
		}
		return completedTodoList;
	}

	public ArrayList<TodoListDTO> findTodoListByCategory(String categoryName){
		ArrayList<TodoListDTO> todoListByCategory=new ArrayList<>();
		for(TodoListDTO todo:todoList){
			if(todo.getTodoCategory().equals(categoryName)){
				todoListByCategory.add(todo);
				Collections.sort(todoListByCategory,new Comparator<TodoListDTO>() {
					@Override
					public int compare(TodoListDTO o1, TodoListDTO o2){
						return (o1.getTodoDeadline().compareTo(o2.getTodoDeadline()));
					} 
				});
			}
		}
		return todoListByCategory;
	}

	public ArrayList<TodoListDTO> findTodoListByKeyword(String keyword){
		ArrayList<TodoListDTO> todoListByKeyword=new ArrayList<>();
		for(TodoListDTO todo:todoList){
			String content=todo.getTodoContent();
			if(content.contains(keyword)){
				todoListByKeyword.add(todo);
				Collections.sort(todoListByKeyword,new Comparator<TodoListDTO>() {
					@Override
					public int compare(TodoListDTO o1, TodoListDTO o2){
						return (o1.getTodoDeadline().compareTo(o2.getTodoDeadline()));
					} 
				});
			}
		}
		return todoListByKeyword;
	}

	public boolean updateTodoContents(Long todoId, String content){
		boolean result=false;
		for(TodoListDTO todo:todoList){
			if(todo.getTodoId().equals(todoId)){
				todo.setTodoContent(content);
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean updateTodoCompleted(Long todoId){
		boolean result=false;
		for(TodoListDTO todo:todoList){
			if(todo.getTodoId().equals(todoId)){
				todo.setTodoCategory(completeCategory);
				result=true;
				break;
			}
		}
		return result;
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

	public boolean updateDeadline(Long todoId, String deadline){
		boolean result=false;
		for(TodoListDTO todo:todoList){
			if(todo.getTodoId().equals(todoId)){
				todo.setTodoDeadline(deadline);
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean updateCategoryName(Long categoryId, String categoryName){
		boolean result=false;
		String beforeCategoryName="";
		for(TodoCategoryDTO category:categoryList){
			if(category.getCategoryId().equals(categoryId)){
				beforeCategoryName=category.getCategoryName();
				category.setCategoryName(categoryName);
				result=true;
			}
		}
		if(!result){
			return result;
		}
		for(TodoListDTO todo:todoList){
			if(!todo.getTodoCategory().equals(beforeCategoryName)){
				continue;
			}
			todo.setTodoCategory(categoryName);
		}
		return result;
	}

	public boolean deleteTodo(Long todoId){
		boolean result=false;
		for(int i=0;i<todoList.size();i++){
			if(todoList.get(i).getTodoId().equals(todoId)){
				todoList.remove(i);
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean deleteAllCompleted(){
		boolean result=false;
		for(Iterator<TodoListDTO> it = todoList.iterator(); it.hasNext();){
			TodoListDTO cur=it.next();
			if(cur.getTodoCategory().equals(completeCategory)){
				it.remove();
				result=true;
			}
		}
		return result;
	}

	public boolean deleteCategory(Long categoryId){
		boolean result=false;
		String deleteCategoryName="";
		for(Iterator<TodoCategoryDTO> it = categoryList.iterator(); it.hasNext();){
			TodoCategoryDTO cur=it.next();
			if(cur.getCategoryId().equals(categoryId)){
				deleteCategoryName=cur.getCategoryName();
				it.remove();
				result=true;
				break;
			}
		}
		if(!result){
			return result;
		}
		for(Iterator<TodoListDTO> it = todoList.iterator(); it.hasNext();){
			TodoListDTO cur=it.next();
			if(cur.getTodoCategory().equals(deleteCategoryName)){
				cur.setTodoCategory(defaultCategory);
				result=true;
			}
		}
		return result;
	}
}