printjson(db.people.insert({
    sex : "Female",
    first_name : "Wiktoria",
    last_name : "Cocek",
    job : "Filmmaker",
    email : "wiktoria@gmail.com",
    location: {
        city : "Warsaw",
        address: {
            streetname : "Filmowa",
            streetnumber : "123"
            },
        },
    description: "This is the description.",
    height: "180",
    weight:"70",
    birth_date:"1996-05-01T00:00:00Z",
    nationality:"Poland",
    credit: [
        {
            type : "maestro",
            number : "6556021178991331",
            currency : "PLN",
            balance : "12345678900",
            },
        ]
    }))