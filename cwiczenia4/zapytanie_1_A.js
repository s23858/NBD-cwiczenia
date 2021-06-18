var zad1 = db.people.aggregate(
    [
        {$match : { heightFloat : {$gt : -1}, weightFloat : {$gt : -1}}},
        {$group : { _id : "$sex", avgH : {$avg : "$heightFloat"}, avgW : {$avg : "$weightFloat"}}}
    ]
)

zad1.forEach(printjson);    