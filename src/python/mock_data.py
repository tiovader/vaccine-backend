import pandas as pd
from sqlalchemy import create_engine
from sqlalchemy.sql import text

engine = create_engine("postgresql+psycopg2://postgres:mysecretpassword@localhost:5432/backend")
with engine.connect() as connection, open("data/init_table.sql") as sql_file:
    connection.execute(text(sql_file.read()))

    regiao = pd.read_csv("data/regiao.csv")
    regiao.to_sql("regiao", con=connection, if_exists="append", index=False)

    estado = pd.read_csv("data/estado.csv")
    estado.to_sql("estado", con=connection, if_exists="append", index=False)

    municipio = pd.read_csv("data/municipio.csv")
    municipio.to_sql("municipio", con=connection, if_exists="append", index=False)

    unidade_basica = pd.read_csv("data/unidade_basica.csv")
    unidade_basica.to_sql("unidade_basica", con=connection, if_exists="append", index=False)

    connection.commit()