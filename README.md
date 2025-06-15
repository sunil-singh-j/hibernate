Steps to create a project for mavan
Refer main brach for hibernate below 6
Refer hibernate7


 for hibernate v 6+
Select new  mavan project -next select Archetype -catlog :internal – select org.apache.maven.archetypes mavan -archetype-quickstart version 1.1 next—enter group Id: artifact Id   
After this your folder structure will be created 
Now  go to src/main  and created a folder called resouces     it will look like  or  
Now create a hibernate.cfg.xml file in resources it look like   

Hibernate.cfg.xml file is used to the database info like database port no and DB credentials with help 
Of <hibernate-configuration> tag 
And if you don’t want to annotations for mapping means we should map our entity class here with 
The help of <mapping class=”entity class path”/> or you can use annotation’s for this 
Next  we need  to create a HibernateUtil.java class  src directly or by creating util pakage
This class will be responsible to provide the sessionfactory object   
We can ges sessionFactory object in two based on the hibernate version if you are using hibernate version 6+ the you should follow below steps 
Using hibernate v 6+
Here we 3 steps in this class
1 . load registry form hibernate.cfg.xml
StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
2. add annotated classes (instead of mapping in hibernate.cfg.xml we can use this)
MetadataSources sources = new MetadataSources(registry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Certificate.class);
3 build metadata and session factory 
Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build
we need to create a getter method for the private sessionFactory  which will be used to create 
the session object while dealing with crud operations
2 Using hibernate version below 6
sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Certificate.class).buildSessionFactory();
here also we need to create a getter method for the private sessionFactory   which will be used to create the session object while dealing with crud operations
or
✅ Steps to Create a Hibernate Maven Project
1. Create a Maven Project in Eclipse
•	Open Eclipse IDE.
•	Go to File → New → Maven Project.
•	Click Next.
•	Select Archetype:
o	Catalog: Internal
o	Choose: org.apache.maven.archetypes → maven-archetype-quickstart → version 1.1
•	Click Next.
•	Enter:
o	Group ID: (e.g., com.example)
o	Artifact ID: (e.g., HibernateApp)
•	Click Finish.
________________________________________
2. Project Structure
After creating the Maven project, the structure will be:
HibernateApp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/   ← You need to create this folder manually
│   └── test/
└── pom.xml
________________________________________
3. Create resources Folder
•	Go to src/main/ → Right-click → New → Folder → Name it resources.
•	This is where configuration files like hibernate.cfg.xml will reside.
________________________________________
4. Add hibernate.cfg.xml Configuration File
•	Create a file named hibernate.cfg.xml under src/main/resources.
•	This file contains:
o	JDBC connection URL
o	DB username & password
o	Hibernate dialect
o	Table creation policy (hbm2ddl.auto)
o	Optionally: Mapping of entity classes (if not using annotations)
________________________________________
5. Create HibernateUtil Class
•	Create a class HibernateUtil in the src/main/java directory (inside a util package).
•	This class is responsible for creating and providing a SessionFactory.
________________________________________
✅ How to Create SessionFactory (Two Ways)
________________________________________
▶️ Approach 1: Hibernate 6 and Above
Hibernate 6+ uses the Java Service API and builder pattern for bootstrapping.
You need the following classes/interfaces:
Step	Classes/Interfaces Involved	Purpose
1.	StandardServiceRegistryBuilder	Reads and builds configuration registry from hibernate.cfg.xml
2.	StandardServiceRegistry	Holds all Hibernate settings
3.	MetadataSources	Register annotated classes
4.	Metadata	Compiles mappings and configuration
5.	SessionFactoryBuilder → SessionFactory	Builds final session factory
✅ Steps:
1.	Load registry using StandardServiceRegistryBuilder
2.	Register entity classes using MetadataSources.addAnnotatedClass(...)
3.	Build metadata using getMetadataBuilder().build()
4.	Create session factory using getSessionFactoryBuilder().build()
________________________________________
▶️ Approach 2: Hibernate Below Version 6
This is the older (and simpler) approach using org.hibernate.cfg.Configuration.
Step	Classes/Interfaces Involved	Purpose
1.	Configuration	Loads hibernate.cfg.xml and registers entity classes
2.	SessionFactory	Built directly from Configuration
✅ Steps:
1.	Create a Configuration object.
2.	Load settings via .configure("hibernate.cfg.xml").
3.	Register entity classes using .addAnnotatedClass(...).
4.	Call .buildSessionFactory() to get the SessionFactory.
________________________________________
🔄 Common for Both
•	Define a private static SessionFactory field.
•	Create a public static method getSessionFactory() to access it across your project.
•	You use sessionFactory.openSession() to start interacting with the database.
________________________________________
6. Add Dependencies in pom.xml
Ensure the following dependencies are included:
•	Hibernate Core
•	MySQL (or your DB) Connector
•	JUnit (optional for testing)
________________________________________
✅ Summary
Aspect	Hibernate 6+	Hibernate <6
Configuration class	StandardServiceRegistry, MetadataSources, Metadata	Configuration
Entity registration	.addAnnotatedClass()	.addAnnotatedClass() or <mapping> in XML
SessionFactory creation	SessionFactoryBuilder	buildSessionFactory()
XML required?	Optional if using annotations	Required unless annotations used






