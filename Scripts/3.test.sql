select * from dog;

desc dog;5

select id, kind, price, image, country, height, weight, content, readcount from dog;

select id, kind, price, image, country, height, weight, content, readcount from dog where id = 1; 

insert into dog values (5, '비숑', 5000, 'shong.jpg', '프랑스', 1 , 20 , '귀엽다', 0);

delete from dog where id = 5;

update dog set readcount = readcount + 1 where id = 1;


