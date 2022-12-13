# inventario

Se anexa script, el cual debe correrse para su funcionamiento, por otro lado el nombre de la base de datos que se utilizo para realizar las pruebas es "inventario". 
Se puede cambiar el nombre en el archivo application.properties

CREATE TABLE
    productos
    (
        pro_id INTEGER DEFAULT nextval('prodcutos_pro_id_seq'::regclass) NOT NULL,
        pro_nombre CHARACTER VARYING(20) NOT NULL,
        pro_estado CHARACTER VARYING(1) DEFAULT 'A'::CHARACTER VARYING NOT NULL,
        CONSTRAINT prodcutos_pkey PRIMARY KEY (pro_id)
    );
    
Nota: El aplicativo se encuentra documentado con swagger: 
![image](https://user-images.githubusercontent.com/31300075/207228570-05616fef-56f2-4a8c-8428-7df08db8c615.png)


    
    
