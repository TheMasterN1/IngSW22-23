FROM mariadb

ENV MARIADB_USER pippo
ENV MARIADB_PASSWORD pippo
ENV MARIADB_ROOT_PASSWORD 123
ENV MARIADB_DB ratatouille

COPY ./dbRatatouille.sql /docker-entrypoint-initdb.d/

EXPOSE 3306