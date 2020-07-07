const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
//const router = express.Router();
const app = express();
const port = 4000;

let books= [];

app.use(cors());
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.post('/book',(req,res)=>{
    const book = req.body;
    // Output the book to the console for debugging
    books.push(book);
    //console.log("Book"+book);
    res.send('Book is added to the database');
    //res.end("yes");
});

app.get('/books', (req, res) => {
    res.json(books);
});

app.get('/book/:isbn', (req, res) => {
    // Reading isbn from the URL
    const isbn = req.params.isbn;
    // Searching books for the isbn
    for (let book of books) {
    if (book.isbn === isbn) {
    res.json(book);
    return;
        }
    }
    // Sending 404 when not found something is a good practice
    res.status(404).send('Book not found');
});  

app.delete('/book/:isbn', (req, res) => {
    // Reading isbn from the URL
    const isbn = req.params.isbn;
    // Remove item from the books array
    books = books.filter(i => {
        if (i.isbn !== isbn) {
            return true;
        }
        return false;
    });
     
    res.send('Book is deleted');
});
   
app.post('/book/:isbn', (req, res) => {
    // Reading isbn from the URL
    const isbn = req.params.isbn;
    const newBook = req.body;
    // Remove item from the books array
    for (let i = 0; i < books.length; i++) {
    let book = books[i]
    if (book.isbn === isbn) {
    books[i] = newBook;
    }
    }
    res.send('Book is edited');
});
    
    
app.listen(port, () => console.log(`Book Store app listening on port ${port}!`));