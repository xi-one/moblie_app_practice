from email.quoprimime import unquote
from enum import unique
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String

USER = " "
PW = " "
URL = " "
PORT = " "
DB = " "

engine = create_engine("postgresql://{}:{}@{}:{}/{}".format(USER, PW, URL,PORT, DB))
db_session = scoped_session(sessionmaker(autocommit=False, autoflush=False, bind=engine))
Base = declarative_base()
Base.query = db_session.query_property()

class User(Base):
    __tablename__ = 'users'
    id = Column(Integer, primary_key=True)
    name = Column(String(50), unique=True)
    passwd = Column(String(120), unique=False)
    def __init__(self, name=None, passwd=None):
        self.name = name
        self.passwd = passwd
    def __repr__(self):
        return f'<User {self.name!r}>'


class Recipe(Base):
    __tablename__ = 'recipe'

    maker = Column(String(50), primary_key=True)
    
    RCP_NM = Column(String(50), primary_key=True)
    RCP_WAY2 = Column(String(50),unique = False)
    INFO_ENG = Column(String(50), unique = False)
    INFO_WGT = Column(String(50), unique = False) 
    RCP_PARTS_DTLS = Column(String(50), unique = False)
    MANUAL01 = Column(String(500), unique = False)
    MANUAL02 = Column(String(500), unique = False)
    MANUAL03 = Column(String(500), unique = False)
    MANUAL04 = Column(String(500), unique = False)
    MANUAL05 = Column(String(500), unique = False)
    MANUAL06 = Column(String(500), unique = False)
    MANUAL07 = Column(String(500), unique = False)
    MANUAL08 = Column(String(500), unique = False)
    MANUAL09 = Column(String(500), unique = False)
    MANUAL10 = Column(String(500), unique = False)
    MANUAL11 = Column(String(500), unique = False)
    MANUAL12 = Column(String(500), unique = False)
    MANUAL13 = Column(String(500), unique = False)
    MANUAL14 = Column(String(500), unique = False)
    MANUAL15 = Column(String(500), unique = False)
    MANUAL16 = Column(String(500), unique = False)
    MANUAL17 = Column(String(500), unique = False)
    MANUAL18 = Column(String(500), unique = False)
    MANUAL19 = Column(String(500), unique = False)
    MANUAL20 = Column(String(500), unique = False)

    def __init__(self, maker=None, RCP_NM=None, RCP_WAY2=None, INFO_ENG=None, INFO_WGT=None, RCP_PARTS_DTLS=None, MANUAL01=None, MANUAL02=None, MANUAL03=None, MANUAL04=None, MANUAL05=None, MANUAL06=None, MANUAL07=None, MANUAL08=None, MANUAL09=None, MANUAL10=None, MANUAL11=None, MANUAL12=None, MANUAL13=None, MANUAL14=None, MANUAL15=None, MANUAL16=None, MANUAL17=None, MANUAL18=None, MANUAL19=None, MANUAL20=None):
        self.maker = maker
    
        self.RCP_NM = RCP_NM
        self.RCP_WAY2 = RCP_WAY2
        self.INFO_ENG = INFO_ENG
        self.INFO_WGT = INFO_WGT
        self.RCP_PARTS_DTLS = RCP_PARTS_DTLS
        self.MANUAL01 = MANUAL01
        self.MANUAL02 = MANUAL02
        self.MANUAL03 = MANUAL03
        self.MANUAL04 = MANUAL04
        self.MANUAL05 = MANUAL05
        self.MANUAL06 = MANUAL06
        self.MANUAL07 = MANUAL07
        self.MANUAL08 = MANUAL08
        self.MANUAL09 = MANUAL09
        self.MANUAL10 = MANUAL10
        self.MANUAL11 = MANUAL11
        self.MANUAL12 = MANUAL12
        self.MANUAL13 = MANUAL13
        self.MANUAL14 = MANUAL14
        self.MANUAL15 = MANUAL15
        self.MANUAL16 = MANUAL16
        self.MANUAL17 = MANUAL17
        self.MANUAL18 = MANUAL18
        self.MANUAL19 = MANUAL19
        self.MANUAL20 = MANUAL20


#Base.metadata.drop_all(bind=engine)
Base.metadata.create_all(bind=engine)

from flask import Flask
from flask import request
from flask import jsonify
from werkzeug.serving import WSGIRequestHandler
import json
import json
WSGIRequestHandler.protocol_version = "HTTP/1.1"
app = Flask(__name__)
@app.route("/adduser", methods=['POST'])
def add_user():
    content = request.get_json(silent=True)
    name = content["name"]
    passwd = content["passwd"]
    if db_session.query(User).filter_by(name=name).first() is None:
        u = User(name=name, passwd=passwd)
        db_session.add(u)
        db_session.commit()
        return jsonify(success=True)
    else:
        return jsonify(success=False)



@app.route("/login", methods=['POST'])
def login():
    content = request.get_json(silent=True)
    name = content["name"]
    passwd = content["passwd"]

    check = False
    result = db_session.query(User).all()
    for i in result:
        if i.name == name and i.passwd == passwd:
            check = True
    return jsonify(success=check)


@app.route("/addrecipe", methods=['POST'])
def add_recipe():
    content = request.get_json(silent=True)
    maker = content["maker"]
    RCP_NM = content["RCP_NM"]
    RCP_WAY2 = content["RCP_WAY2"]
    INFO_ENG = content["INFO_ENG"]
    INFO_WGT = content["INFO_WGT"]
    RCP_PARTS_DTLS = content["RCP_PARTS_DTLS"]
    MANUAL01 = content["MANUAL01"]
    MANUAL02 = content["MANUAL02"]
    MANUAL03 = content["MANUAL03"]
    MANUAL04 = content["MANUAL04"]
    MANUAL05 = content["MANUAL05"]
    MANUAL06 = content["MANUAL06"]
    MANUAL07 = content["MANUAL07"]
    MANUAL08 = content["MANUAL08"]
    MANUAL09 = content["MANUAL09"]
    MANUAL10 = content["MANUAL10"]
    MANUAL11 = content["MANUAL11"]
    MANUAL12 = content["MANUAL12"]
    MANUAL13 = content["MANUAL13"]
    MANUAL14 = content["MANUAL14"]
    MANUAL15 = content["MANUAL15"]
    MANUAL16 = content["MANUAL16"]
    MANUAL17 = content["MANUAL17"]
    MANUAL18 = content["MANUAL18"]
    MANUAL19 = content["MANUAL19"]
    MANUAL20 = content["MANUAL20"]
    if db_session.query(Recipe).filter_by(maker = maker, RCP_NM = RCP_NM).first() is None:

        info = Recipe(maker, RCP_NM, RCP_WAY2, INFO_ENG, INFO_WGT, RCP_PARTS_DTLS, MANUAL01, MANUAL02, MANUAL03, MANUAL04, MANUAL05, MANUAL06, MANUAL07, MANUAL08, MANUAL09, MANUAL10, MANUAL11, MANUAL12, MANUAL13, MANUAL14, MANUAL15, MANUAL16, MANUAL17, MANUAL18, MANUAL19, MANUAL20)
        db_session.add(info)
        db_session.commit()
        return jsonify(success = True)
    else:
        return jsonify(success=False)

@app.route("/searchrecipe", methods=['POST'])
def search_recipe():
    content = request.get_json(silent=True)
    RCP_NM = content["RCP_NM"]
    total_count = 0
    ret = {}
    ret_sub = {}
    recipes = []
    

    result = db_session.query(Recipe).all()
    for i in result:
        if RCP_NM in i.RCP_NM:
            recipe = {}
            total_count = total_count + 1
            recipe["maker"] = i.maker
            recipe["RCP_NM"] = i.RCP_NM
            recipe["RCP_WAY2"] = i.RCP_WAY2
            recipe["INFO_ENG"] = i.INFO_ENG
            recipe["INFO_WGT"] = i.INFO_WGT
            recipe["RCP_PARTS_DTLS"] = i.RCP_PARTS_DTLS
            recipe["MANUAL01"] = i.MANUAL01
            recipe["MANUAL02"] = i.MANUAL02
            recipe["MANUAL03"] = i.MANUAL03
            recipe["MANUAL04"] = i.MANUAL04
            recipe["MANUAL05"] = i.MANUAL05
            recipe["MANUAL06"] = i.MANUAL06
            recipe["MANUAL07"] = i.MANUAL07
            recipe["MANUAL08"] = i.MANUAL08
            recipe["MANUAL09"] = i.MANUAL09
            recipe["MANUAL10"] = i.MANUAL10
            recipe["MANUAL11"] = i.MANUAL11
            recipe["MANUAL12"] = i.MANUAL12
            recipe["MANUAL13"] = i.MANUAL13
            recipe["MANUAL14"] = i.MANUAL14
            recipe["MANUAL15"] = i.MANUAL15
            recipe["MANUAL16"] = i.MANUAL16
            recipe["MANUAL17"] = i.MANUAL17
            recipe["MANUAL18"] = i.MANUAL18
            recipe["MANUAL19"] = i.MANUAL19
            recipe["MANUAL20"] = i.MANUAL20
            recipe["MANUAL_IMG01"] = ""
            recipe["MANUAL_IMG02"] = ""
            recipe["MANUAL_IMG03"] = ""
            recipe["MANUAL_IMG04"] = ""
            recipe["MANUAL_IMG05"] = ""
            recipe["MANUAL_IMG06"] = ""
            recipe["MANUAL_IMG07"] = ""
            recipe["MANUAL_IMG08"] = ""
            recipe["MANUAL_IMG09"] = ""
            recipe["MANUAL_IMG10"] = ""
            recipe["MANUAL_IMG11"] = ""
            recipe["MANUAL_IMG12"] = ""
            recipe["MANUAL_IMG13"] = ""
            recipe["MANUAL_IMG14"] = ""
            recipe["MANUAL_IMG15"] = ""
            recipe["MANUAL_IMG16"] = ""
            recipe["MANUAL_IMG17"] = ""
            recipe["MANUAL_IMG18"] = ""
            recipe["MANUAL_IMG19"] = ""
            recipe["MANUAL_IMG20"] = ""
            recipes.append(recipe)


    ret_sub["total_count"] = total_count
    ret_sub["row"] = recipes
    ret["COOKRCP01"] = ret_sub

    return jsonify(ret)

@app.route("/searchmaker", methods=['POST'])
def search_maker():
    content = request.get_json(silent=True)
    maker = content["maker"]
    total_count = 0
    ret = {}
    ret_sub = {}
    recipes = []
    

    result = db_session.query(Recipe).all()
    for i in result:
        if i.maker == maker:
            recipe = {}
            total_count = total_count + 1
            recipe["maker"] = i.maker
            recipe["RCP_NM"] = i.RCP_NM
            recipe["RCP_WAY2"] = i.RCP_WAY2
            recipe["INFO_ENG"] = i.INFO_ENG
            recipe["INFO_WGT"] = i.INFO_WGT
            recipe["RCP_PARTS_DTLS"] = i.RCP_PARTS_DTLS
            recipe["MANUAL01"] = i.MANUAL01
            recipe["MANUAL02"] = i.MANUAL02
            recipe["MANUAL03"] = i.MANUAL03
            recipe["MANUAL04"] = i.MANUAL04
            recipe["MANUAL05"] = i.MANUAL05
            recipe["MANUAL06"] = i.MANUAL06
            recipe["MANUAL07"] = i.MANUAL07
            recipe["MANUAL08"] = i.MANUAL08
            recipe["MANUAL09"] = i.MANUAL09
            recipe["MANUAL10"] = i.MANUAL10
            recipe["MANUAL11"] = i.MANUAL11
            recipe["MANUAL12"] = i.MANUAL12
            recipe["MANUAL13"] = i.MANUAL13
            recipe["MANUAL14"] = i.MANUAL14
            recipe["MANUAL15"] = i.MANUAL15
            recipe["MANUAL16"] = i.MANUAL16
            recipe["MANUAL17"] = i.MANUAL17
            recipe["MANUAL18"] = i.MANUAL18
            recipe["MANUAL19"] = i.MANUAL19
            recipe["MANUAL20"] = i.MANUAL20
            recipe["MANUAL_IMG01"] = ""
            recipe["MANUAL_IMG02"] = ""
            recipe["MANUAL_IMG03"] = ""
            recipe["MANUAL_IMG04"] = ""
            recipe["MANUAL_IMG05"] = ""
            recipe["MANUAL_IMG06"] = ""
            recipe["MANUAL_IMG07"] = ""
            recipe["MANUAL_IMG08"] = ""
            recipe["MANUAL_IMG09"] = ""
            recipe["MANUAL_IMG10"] = ""
            recipe["MANUAL_IMG11"] = ""
            recipe["MANUAL_IMG12"] = ""
            recipe["MANUAL_IMG13"] = ""
            recipe["MANUAL_IMG14"] = ""
            recipe["MANUAL_IMG15"] = ""
            recipe["MANUAL_IMG16"] = ""
            recipe["MANUAL_IMG17"] = ""
            recipe["MANUAL_IMG18"] = ""
            recipe["MANUAL_IMG19"] = ""
            recipe["MANUAL_IMG20"] = ""
            recipes.append(recipe)


    ret_sub["total_count"] = total_count
    ret_sub["row"] = recipes
    ret["COOKRCP01"] = ret_sub

    return jsonify(ret)


@app.route("/deleterecipe", methods=['POST'])
def delete_recipe():
    content = request.get_json(silent=True)
    maker = content["maker"]
    RCP_NM = content["RCP_NM"]
    
    if db_session.query(Recipe).filter(Recipe.maker==maker, Recipe.RCP_NM==RCP_NM).count() != 0:
        db_session.query(Recipe).filter(Recipe.maker==maker, Recipe.RCP_NM==RCP_NM).delete()
        db_session.commit()
        return jsonify(success = True)

    else:
        return jsonify(success = False)
    





    
    

if __name__ == "__main__":
    app.run(host='localhost', port=8888)
