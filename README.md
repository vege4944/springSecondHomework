#task

#ERD 이미지

![Erd](https://github.com/user-attachments/assets/74ea2a4f-f9aa-47b7-a704-17df73808197)




#SQL 코드 - Task
```
create table task
(
    created_at datetime(6)  null,
    id         bigint auto_increment
        primary key,
    updated_at datetime(6)  null,
    author     varchar(255) not null,
    contents   varchar(255) not null,
    title      varchar(255) not null
);
```



#SQL 코드 - Comment
```
create table comment
(
created_at datetime(6)  null,
id         bigint auto_increment
primary key,
task_id    bigint       null,
updated_at datetime(6)  null,
contents   varchar(255) not null,
username   varchar(255) not null,
constraint FKfknte4fhjhet3l1802m1yqa50
foreign key (task_id) references task (id)
);
```




#Api 명세서
https://documenter.getpostman.com/view/37679486/2sAXjJ7Z34
