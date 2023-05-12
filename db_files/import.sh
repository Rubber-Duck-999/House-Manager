#! /bin/bash

mongoimport --host mongo_db --db house-guard --collection device --type json --file /db_files/device.json