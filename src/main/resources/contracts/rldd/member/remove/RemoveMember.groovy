package contracts.rldd.member.remove

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.DELETE

Contract.make {
    description "DELETE to remove member"
    request {
        urlPath "/members/001"
        method DELETE
    }
    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
            id   : '001',
            name : 'yusong.deng',
            point: 3
        ])
    }
}

