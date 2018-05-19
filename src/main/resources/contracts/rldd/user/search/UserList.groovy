package contracts.rldd.user.search

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.GET

Contract.make {
    description """
        Should get all users info as list
        """
    def userListURL = '/api/users'
    def pageSize = 5
    def currentPage = 0

    request {
        urlPath(userListURL) {
            queryParameters {
                parameter 'page': currentPage
                parameter 'size': pageSize
            }
        }
        method GET
    }

    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body(
            [
                _embedded: [
                    users:
                        ['Yusong Deng', 'Yuexiang Gao', 'Yugang Zhou', 'Di Zhang', 'Jinghu Peng'].withIndex().collect {
                            [
                                id      : it.getSecond(),
                                username: it.getFirst(),
                                avatar  : '',
                            ]
                        }

                ],
                _links   : [
                    "self" : [
                        "href": "http://localhost${userListURL}?page=${currentPage}&size=${pageSize}" as String
                    ],
                    "next" : [
                        "href": "http://localhost${userListURL}?page=${currentPage + 1}&size=${pageSize}" as String
                    ],
                    "first": [
                        "href": "http://localhost${userListURL}?page=0&size=${pageSize}" as String
                    ],
                    "last" : [
                        "href": "http://localhost${userListURL}?page=1&size=${pageSize}" as String
                    ]
                ],
                "page"   : [
                    "size"         : pageSize,
                    "totalElements": pageSize + 1,
                    "totalPages"   : 2,
                    "number"       : currentPage
                ]
            ]
        )
    }
}