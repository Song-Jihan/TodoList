package TodoList;

public class todoCategoryDTO {
  
  private Long categoryId;
  private String categoryName;
  private String categoryDiscription;
  
  public todoCategoryDTO(){}
  
  public todoCategoryDTO(Long categoryId,String categoryName, String categoryDiscription){
    this.categoryId=categoryId;
    this.categoryName=categoryName;
    this.categoryDiscription=categoryDiscription;
  }
  
  public Long getcategoryId(){
    return categoryId;
  }
  
  public void setcategoryId(Long categoryId){
    this.categoryId=categoryId;
  }
  
  public String getcategoryName(){
    return categoryName;
  }
  
  public void setcategoryName(String categoryName){
    this.categoryName=categoryName;
  }
  
  public String getcategoryDiscription(){
    return categoryDiscription;
  }
  
  public void setcategoryDiscription(String categoryDiscription){
    this.categoryDiscription=categoryDiscription;
  }
  
  @Override
  public String toString(){
    return "todoCategoryDTO {categoryId="+categoryId+", categoryName="+categoryName
            +", categoryDiscription="+categoryDiscription+"}";
  }
  
}