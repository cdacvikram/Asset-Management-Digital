# Asset-Management-Digital

Asset Management Digital Release Notes

Release 1.0.0
Last revised July 16, 2017

----------------

CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Features
 * Implementation
 * Integration (with other modules)
 * Installation and configuration
 * SAMPLE JSONS


INTRODUCTION
------------

Asset Management Digital App will add the shops after getting the lat and lng from google maps api and stores the data into the thread safe database and app is deployed as a microservice which internally configures swagger.
It will show the output in JSON format if address is already exists with CurrentAddress and PreviousAddress address and it will add a new shop and response message with 'new shop added'

FEATURES
--------

First, Asset Management Digital App gets the shop name, shopAddress and postal code.
Secondly, App will call a GET reqest to google maps api to get the lat and lng and stores into the database.

IMPLEMENTATION
--------------

Basically, Asset Management Digital service adds the shop and returns list of shops and returns the message also if the same shop name is exists already.
Mock test also runs the features.

INTEGRATION (WITH OTHER MODULES)
--------------------------------
Asset Management Digital is integrated with google api with valid API key which is externalized in the application


INSTALLATION AND CONFIGURATION
------------------------------

0 - Prerequisites:
Should have eclipse and Gradle installed.

1 - Download the projects and copy it into your any local folder:

2 - Configuration:
Import the project - asset-management-digital into workspace.

Refresh the Gradle project into workspace, so all the gradle dependencies will get downloaded into local repository.

asset-management-digital project is a spring boot projects so directly can be started.

2.1. Run as - java application AssetMgmtApp

After successful running all the spring boot applications, go to the browser and hit the url localhost:8080/assetmgmt/swagger-ui.html to test the application

It will display the swagger UI to test all the api's.

SAMPLE JSONS
------------
1. Add a shop:
{
        "shopName": "ShopOne",
        "shopAddress": "CopaCabana,Omkar, Pimple Nilakh, Pimpri-Chinchwad, Maharashtra",
        "shopPostCode": "123344",
        "latitude": "",
        "longitude": ""
    }
	
2. {
        "shopName": "ShopTwo",
        "shopAddress": "CopaCabana,Omkar, Pimple Nilakh, Pimpri-Chinchwad, Maharashtra",
        "shopPostCode": "456734",
        "latitude": "",
        "longitude": ""
    }
	
3. {
        "shopName": "ShopTwo",
        "shopAddress": "CopaCabana,Omkar, Pimple Nilakh, Pimpri-Chinchwad, Maharashtra",
        "shopPostCode": "234567",
        "latitude": "",
        "longitude": ""
    }

