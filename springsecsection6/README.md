To create a MySql DB Container use this command :-
"docker run -p 3307:3306 --name springsecurity -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eazybank -d mysql" Breakdown of the Command: docker run: This is the command used to create and start a new container from a specified image.

-p 3307:3306: This option maps a port on your host machine to a port on the container.

3307: This is the port on your host machine that you will use to connect to the MySQL server. 3306: This is the default port that the MySQL server listens on inside the container. With this mapping, you can connect to MySQL on your host using localhost:3307, and it will be forwarded to the MySQL service running in the container on port 3306. --name springsecurity: This option assigns a name (springsecurity) to the container. This makes it easier to manage the container later (e.g., starting, stopping, or removing it) without needing to reference its container ID.

-e MYSQL_ROOT_PASSWORD=root: This sets an environment variable inside the container. In this case, it sets the MYSQL_ROOT_PASSWORD to root. This is the password for the MySQL root user. You should choose a strong password for production environments.

-e MYSQL_DATABASE=eazybank: This sets another environment variable, MYSQL_DATABASE, which tells MySQL to create a database named eazybank when the container is first started.

-d: This flag runs the container in "detached" mode, meaning it runs in the background and does not block your terminal. You can continue to use your terminal for other commands.

mysql: This is the name of the Docker image you are using to create the container. In this case, it's the official MySQL image from Docker Hub.

Summary In summary, this command creates and starts a new MySQL container with the following characteristics:

The MySQL server inside the container listens on port 3306, which is mapped to port 3307 on your host. The container is named springsecurity. The root password for MySQL is set to root. A database named eazybank is created upon initialization. The container runs in the background. You can then connect to the MySQL server using a MySQL client on your host machine at localhost:3307. with username and password as root.

Short Cut- to remove unwanted or unused imports statement in windows we can press ctrl+alt+o

note:- why we use option in front of class i.e., Optional becuase if customer record not found based on the email then in such scenarion it will return an null value.

Database Name:- eazybank
username:- root
password:- root