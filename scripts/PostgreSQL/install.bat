set PGPASSWORD=PIZZADB
psql --host=localhost --dbname=postgres --username=PIZZADB --port 5432 --echo-all -f setup.sql