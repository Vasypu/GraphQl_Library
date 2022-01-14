First step before start application, create base and change url, password and username in application.properties on your own.<br/>
Some queries and mutations:<br/>
query {<br/>
    getAllBooks {<br/>
    id<br/>
    title<br/>
    author {<br/>
      id<br/>
      name<br/>
    }<br/>
  }<br/>
}

mutation {<br/>
  saveAuthor(name: "Andrew", book: "First AndrBook") {<br/>
    id<br/>
    name<br/>
  }<br/>
}<br/>

mutation {<br/>
  saveBook(title: "First jump", authorName: "Jon Tridle") {<br/>
    id<br/>
    title<br/>
  }<br/>
}<br/>

query {<br/>
  getAuthor(name: "Jon") {<br/>
    id<br/>
    name<br/>
    books {<br/>
      id<br/>
      title<br/>
    }<br/>
  }<br/>
}

query {<br/>
  getBooksByAuthor(authorName: "Jon") {<br/>
    title<br/>
  }<br/>
}<br/>

query {<br/>
  getAuthor(name: "Jon") {<br/>
    id<br/>
    name<br/>
  }
}
