package contracts.rldd.member.list

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.GET

Contract.make {
    description "GET members list"
    request {
        urlPath "/members"
        method GET
    }
    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
            [
                id   : '001',
                name : 'yusong.deng',
                point: 3
            ],
            [
                id   : $(client('002'), server('001')),
                name : $(client('yugang.zhou'), server('yusong.deng')),
                point: $(client(2), server(3))
            ],
            [
                id   : $(client('003'), server('001')),
                name : $(client('yuexiang.gao'), server('yusong.deng')),
                point: $(client(3), server(3))
            ]
        ])
    }
}