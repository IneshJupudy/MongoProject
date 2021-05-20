# SpringBoot-MongoDB_CRUD_API

Currently one left out point is the use of Exception Handlers :- (An excellent imporvement scope).


Reason for Using MongoDB(NoSQL) over SQL :-


-> Highly useful for unstructured data.

-> MongoDB unlike SQL does not use Joins and often is suprisingly much faster in working.

-> Helpful as JSON format is quite universal unlike SQL data.

-> Quick useful integrations with a variety of frameworks.


All the URL's are in the faith of REST protocols and follow off one another in a sensible manner. In an ideal work environment it is important
to keep the url and endpoint names logically relatable.


The database schema is quite working on the hierarchy stature following from classes as seen below :-


PostMan Collection :- 

[
    {
        "id": 5039,
        "name": "Blog with Comments!",
        "comments": [
            {
                "commentID": 25,
                "comment": "Comment 1 - Hey There!",
                "replies": [
                    "Reply - Heloooo!!",
                    "Also a second reply !!"
                ]
            }
        ]
    }
]
