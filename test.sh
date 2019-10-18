#!/bin/bash
# Тестовый curl конвертора

curl -XPOST -v \
-H "Content-Type: application/json" \
localhost:8080/convert \
-d  @- <<EOF
{  "data": {
      "MAIN_OWNER_IS_INSURER": "1",
      "FOR_LEASING": "0",
      "MAIN_USAGE_REGION_KLADR": "77770000445567",
      "GLOBAL_PAY_TYPE": "2",
      "CONTRACT_LENGTH": "17",
      "INSURANCE_OBJECT_USE_AGE": "12",
      "USER_FULLNAME":"Sidoroff Peter Iosifovitch",
      "_DATE_BUY_TS": "2019-10-14T00:00:00"
    }}
EOF

