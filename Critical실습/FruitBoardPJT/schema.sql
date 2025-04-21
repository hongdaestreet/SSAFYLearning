# 데이터베이스 생성 코드
DROP DATABASE IF EXISTS debug_test;
CREATE DATABASE debug_test;
USE debug_test;

# 과일 테이블(fruits) 생성 코드
CREATE TABLE fruits (
    fruit_id INT AUTO_INCREMENT PRIMARY KEY,  		-- 고유번호(기본키), 자동 증가 설정
    fruit_name VARCHAR(50) NOT NULL,   	      			-- 과일 이름
    taste VARCHAR(50) NOT NULL,              		-- 과일의 맛(예: 달콤함, 새콤함 등)
    price INT NOT NULL,                      	-- 과일 가격(원 단위)
    quantity INT NOT NULL                   -- 재고 수량
);

INSERT INTO fruits (fruit_name, taste, price, quantity)
        VALUES ("사과","새콤",3000,1);
INSERT INTO fruits (fruit_name, taste, price, quantity)
        VALUES ("바나나","달콤",2000,4);
INSERT INTO fruits (fruit_name, taste, price, quantity)
        VALUES ("망고","달콤",7000,3);
INSERT INTO fruits (fruit_name, taste, price, quantity)
        VALUES ("레몬","심",4000,8);

-- select * from fruits;