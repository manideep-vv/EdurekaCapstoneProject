queries
======

SELECT * FROM product;
select * from category;
select * from orders;
select * from customer;

-- drop table employee_laptops,employee,laptop;
drop table product,category,orders,customer;

i have already attached the postman collection in this git repo named "Edureka-thursdays order mgmnt sys.postman_collection.json"

1) first we should create customer,
2) next we should create product, then category will be saved automatically as part of cascadeType.All
3) next we should create order
create customer
=================
{
    "name":"manideep"   
}
request-2
======
{
    "name":"sai prakash"   
}
create product
------------
- no need to create category seperately as this will be cascaded/insert automatically due to cascade type
==============
request -1
===========
{

    "name":"keyboard",
    "price": 550.263,
    "category":{
        "name":"electronics"
    }
}
request -2
===========
{

    "name":"cellphone",
    "price": 111.263,
    "category":{
        "name":"electronics"
    }
}
request -3
===========
{

    "name":"shirt",
    "price": 111.22,
    "category":{
        "name":"clothes"
    }
}
request -4
===========
{

    "name":"pant",
    "price": 222.33,
    "category":{
        "name":"clothes"
    }
}
create order
=============
request -1
===========
{

    "quantity":2,
    "product":{
        "id":13
    },
    "customer":{
        "id":20
    }
}

update order
=======
request -1
===========
{
    "id":21,
    "quantity":20,
    "product":{
        "id":13
    },
    "customer":{
        "id":20
    }
}

Finding all products in a Order
--------------------------------------------------
http://localhost:8080/getAllProductsInOrders

- Finding all Orders for a Customer -difficult

- Finding all products for a Category
	http://localhost:8080/getAllProductsForACategory
	
- Finding the Customer with the most number of Orders
- Finding the Category with no Products
- Finding the Orders with more than 1000 Rs in value