CREATE TABLE "books"
(
 "id"       serial NOT NULL,
 "name"     varchar(255) NOT NULL,
 "author"   varchar(255) NOT NULL,
 "quantity" int NOT NULL,
 "price"    decimal(12,2) NOT NULL,
 CONSTRAINT "PK_books" PRIMARY KEY ( "id" )
);

CREATE TABLE "order"
(
 "id"          serial NOT NULL,
 "customer_id" integer NOT NULL,
 CONSTRAINT "PK_order" PRIMARY KEY ( "id" )
);

CREATE TABLE "order_book"
(
 "order_id"       integer NOT NULL,
 "book_id"        integer NOT NULL,
 "order_quantity" integer NOT NULL,
 CONSTRAINT "FK_14" FOREIGN KEY ( "order_id" ) REFERENCES "order" ( "id" ),
 CONSTRAINT "FK_19" FOREIGN KEY ( "book_id" ) REFERENCES "books" ( "id" )
);

CREATE INDEX "fkIdx_14" ON "order_book"
(
 "order_id"
);

CREATE INDEX "fkIdx_19" ON "order_book"
(
 "book_id"
);
