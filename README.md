First step before start application, create base and change url, password and username in application.properties on your own.
Some queries and mutations:
query {
    getAllBooks {
    id
    title
    author {
      id
      name
    }
  }
}

mutation {
  saveAuthor(name: "Andrew", book: "First AndrBook") {
    id
    name
  }
}

mutation {
  saveBook(title: "First jump", authorName: "Jon Tridle") {
    id
    title
  }
}

query {
  getAuthor(name: "Jon") {
    id
    name
    books {
      id
      title
    }
  }
}

query {
  getBooksByAuthor(authorName: "Jon") {
    title
  }
}

query {
  getAuthor(name: "Jon") {
    id,
    name
  }
}
