1. Who checked out the book 'The Hobbit’?

   __Anand Beck__ 

   ```sqlite
   SELECT name FROM member WHERE id = 
   (SELECT member_id FROM checkout_item WHERE book_id = 
    (SELECT id FROM book WHERE title = 'The Hobbit'));
   ```

   

2. How many people have not checked out anything?

   __37__ 

   ```sqlite
   SELECT COUNT(*) FROM member WHERE id NOT IN 
   (SELECT DISTINCT member_id FROM checkout_item);
   ```

   

3. What books and movies aren't checked out?

   __Books: Fellowship of the Ring, 1984, Tom Sawyer, Catcher in the Rye, To Kill a Mockingbird, Domain Driven Design__

   __Movies: Thin Red Line, Crouching Tiger, Hidden Dragon, Lawrence of Arabia, Office Space__ 

   ```sqlite
   SELECT * FROM book WHERE id NOT IN 
   (SELECT book_id FROM checkout_item WHERE book_id IS NOT NULL);
   
   SELECT * FROM movie WHERE id NOT IN 
   (SELECT movie_id FROM checkout_item WHERE movie_id IS NOT NULL);
   ```

   

4. Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.

   ```sqlite
   INSERT INTO book (title) VALUES ('The Pragmatic Programmer');
   INSERT INTO member (name) VALUES ('Shi QIU');
   
   INSERT INTO checkout_item (member_id, book_id) VALUES 
   ((SELECT id FROM member WHERE name = 'Shi QIU'), 
    (SELECT id FROM book WHERE title = 'The Pragmatic Programmer'));
    
   SELECT name FROM member WHERE id = 
   (SELECT member_id FROM checkout_item WHERE book_id = 
    (SELECT id FROM book WHERE title = 'The Pragmatic Programmer'));
   >>> Shi QIU
   ```

   

5. Who has checked out more than 1 item? 

   __Anand Beck, Frank Smith__ 

   ```sqlite
   SELECT name FROM member WHERE id IN (SELECT member_id FROM checkout_item GROUP BY member_id HAVING COUNT(*) > 1);
   ```

   

