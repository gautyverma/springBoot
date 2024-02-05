https://www.javatpoint.com/microservices

---------------------------------------
Ports Standarization

- spring cloud config server = 8888
- limits-service = 8080
- currency exchange service = 8000, 8001, 8002,....
- currency conversion service = 8100, 8101, 8102,....
- Eureka naming-server = 8761

----------------------------------------
Microservice Base layout of project

![img_1.png](img_1.png)
-----------------------------------------
Step 0 - Initialize the local-git-repo for Spring-Cloud-Config-Server

![img.png](img.png)
-----------------------------------------
Step - 1 - Base Layout of two microservices

- currency conversion service
- currency exchange service -> CURD ops

![img_2.png](img_2.png)
-----------------------------------------
Step - 2 - Load Balancing

![img_3.png](img_3.png)

------------------------------------------
Step - 3 - Naming Server to get upInstance details

![img_4.png](img_4.png)