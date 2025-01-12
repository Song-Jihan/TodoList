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

- TodoListRepository 초기단계의 구현완료
  > 할 일 및 카테고리에 대한 수정, 삭제, 검색 기능 구현완료

- TodoListMain의 finally구문 제거
  > 예외 및 경고처리 방지

#### 2025.01.12.

- TodoListService 일부 구현
  > 할 일 및 카테고리에 대한 검색, 추가 기능 구현완료
  > 특정 데이터값 반환 함수
    > > TodoListDTO값 리턴
    > > TodoCategoryDTO값 리턴
