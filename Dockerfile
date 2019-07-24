FROM postgres: 11.1
MANUTENÇÃO Bruno
COPY schema.sql /docker-entrypoint-initdb.d/
COPY data.sql /docker-entrypoint-initdb.d/