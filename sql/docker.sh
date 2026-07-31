docker volume create mariadb_data

docker run -d --name mariadb -p 3306:3306 -v mariadb_data:/var/lib/mysql -e MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=yes mariadb:latest

---

docker volume create postgres_data

docker run -d --name postgresql -p 5432:5432 -v postgres_data:/var/lib/postgresql/data -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=teste postgres:latest

---

docker run -d \
  --name mariadb \
  -p 3306:3306 \
  -v mariadb_data:/var/lib/mysql \
  -e MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=yes \
  -e MARIADB_DATABASE=teste \
  mariadb:latest
  
---

docker run -d \
  --name postgresql \
  -p 5432:5432 \
  -v postgres_data:/var/lib/postgresql/data \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=teste \
  postgres:latest
  
 ---
 