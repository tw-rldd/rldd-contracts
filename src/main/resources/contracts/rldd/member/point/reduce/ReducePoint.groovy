package contracts.rldd.member.point.reduce

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.POST

Contract.make {
    description "POST to reduce point"
    request {
        urlPath "/members/001/reducePoint"
        method POST
    }
    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
            id   : '001',
            name : 'yusong.deng',
            point: 2
        ])
    }
}
