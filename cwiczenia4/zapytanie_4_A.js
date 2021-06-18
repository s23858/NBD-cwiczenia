var zad4 = db.people.aggregate(
    [
        {$addFields: { bmi : { $divide : ["$weightFloat", {$pow: [{$divide : ["$heightFloat", 100]}, 2]}]}}},
        {$group : { _id : "$nationality", maxBMI : {"$max" : "$bmi"}, minBMI : {"$min" : "$bmi"}, avgBMI : { $avg : "$bmi"}}}
    ]
);

zad4.forEach(printjson);    