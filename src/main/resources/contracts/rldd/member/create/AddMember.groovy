package contracts.rldd.member.create

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.POST

Contract.make {
    description "POST to create member"
    request {
        urlPath "/members/004"
        method POST
    }
    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
            id   : '004',
            name : 'jinhu.peng',
            point: 3
        ])
    }
}

