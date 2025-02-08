# What is MongoRepository<T, ID> ?
MongoRepository<T, ID> is an important interface which will help you to write CRUD operations easily. 
For example, in our case we will extend our custom Repository interface from this interface. However, It is just like JpaRepositry<T, ID> that we use to write CRUD operations in case of SQL databases.
Both of them extends PagingAndSortingRepository<T, ID> and QueryByExampleExecutor<T> interfaces.
We can go through the primary diagram of this article in order to understand complete hierarchy of MongoRepository<T, ID> & JpaRepositry<T, ID> as well.
The MongoRepository interface is a part of the Spring Data MongoDB module, which integrates MongoDB with Spring Data, a broader part of the Spring Framework that provides support for data access across various database types.

# 1 : Create a Spring Boot Project using STS(Spring Tool Suite)
Here, we will use STS(Spring Tool Suite) to create our Spring Boot Project. 
If you are new to Spring Boot, visit Internal Link to create a sample project in spring boot using STS. 
While creating a project in STS, add starters ‘Spring Data MongoDB’, and ‘Lombok’ in order to get the features of MongoDB.
Furthermore, if you are new to ‘Lombok’, kindly visit ‘How to configure Lombok‘ and to know all about it in detail.

