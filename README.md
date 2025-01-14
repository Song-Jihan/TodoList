# TodoList

## Java로 할 일 목록(TodoList) 만들기 

### 프로젝트 목적

- 지금까지 무언가를 만들어본 경험이 없기에 해보는 첫번째 미니 프로젝트(?)

- 미니 프로젝트를 통한 Java 문법 공부하기

- 프로젝트를 계획하는데 필요한 구상 방법 터득하기

- 타인의 오픈소스 읽기를 통한 실력 향상시키기 

- Github 업로드를 통한 Github 친해지기

- 할 일 목록을 통해 내가 할 일들을 기억하기 용이하게 만들어줌


### 프로젝트 밴치마킹

- Google tasks

- ktaekim2/todoList 깃허브

### Class

  * TodoListMain
  > TodoListService의 API를 토대로 시각적 정보 제공

  * TodoListDTO
  >할 일 목록란의 인터페이스 지정관리

  * TodoCategoryDTO
  >카테고리의 인터페이스 지정관리

  * TodoListService
  > TodoListRepository의 기능을 담은 API

  * TodoListRepository
  >할 일 및 카테고리들을 List형태로 저장, 검색, 관리



### 업데이트 일지

#### 2025.01.05.

- 프로젝트 바탕 구상
  > 프로젝트의 목적 및 기능

- 프로젝트내 필요한 인터페이스 구상
  > 할 일 목록란에 필요한 인터페이스 구상
  > 할 일 목록의 카테고리에 필요한 인터페이스 구상

- TodoListMain 페이지 작성


#### 2025.01.08.

- TodoListDTO 페이지 작성

- TodoCategoryDTO 페이지 작성

- Github Readme 공부하기 및 프로젝트 파일 첫 업로드

#### 2025.01.10.

- TodoListReapository 일부 구현
  > 할 일 및 카테고리 요소 추가 기능 구현
  > 특정 카테고리의 이름 수정 기능 구현

#### 2025.01.11.

- Github 업로드 파일 내 package 파일 추가로 인한 java파일들 경로 이동

- TodoListRepository 구현완료
  > 할 일 및 카테고리에 대한 수정, 삭제, 검색 기능 구현완료

- TodoListMain의 finally구문 제거
  > 예외 및 경고처리 방지

#### 2025.01.12.

- TodoListService 일부 구현
  > 할 일 및 카테고리에 대한 검색, 추가 기능 구현완료
  > 특정 데이터값 반환 함수
    > TodoListDTO값 리턴, TodoCategoryDTO값 리턴

#### 2025.01.13.

- TodoListService 구현 완료
  > 할 일 및 카테고리에 대한 삭제, 수정 기능 구현완료
  > Main페이지에 기본 카테고리 세팅 메서드 첨부

- TodoListService의 todoListId, categoryListId static에서 지역변수로 변환
  > static으로 인한 Id정수가 순차적으로 증가하지 않는 버그 발생

- TodoListService의 todoId, categoryId 의 이름을 todoListId, categoryListId 로 변경
  > 각 메서드내 지역변수와 메서드 밖에서 할 일 및 카테고리의 id 개수를 세주는 변수의 이름 동일한 문제가 있었음

- 할 일 수정 기능에서 다른 카테고리로 수정하는 기능 버그 수정
  > 기존의 카테고리 이름 수정 기능과 동일한 로직으로 작성한 문제 발견

- TodoListService의 returnTodoId, returnCategoryId 에서 목록들이 비어있다면 0이 나오도록 변경
  > 해당 리턴을 건네주는 메서드들을 이용하는 각종 메서드에서 잘못된 입력을 받을 시, 조기에 로직을 종료시켜줌

- TodoListDTO의 인스턴스 메서드에 todoContent를 빼먹고 객체를 생성시키는 오류 발견

#### 2025.01.14.

- Todo에 제목 추가
  > 제목 작성은 필수, 내용란 작성은 빈칸이여도 괜찮게 수정

- 할 일 생성일 제거
  > 불필요 하다고 판단

- 카테고리 설명(content) 수정 기능 추가

- 완료표시한 할 일 다시 완료 취소 기능 추가
  > TodoListDTO에 본래 있던 카테고리의 이름을 기억해놨다가 그곳으로 이동

