package contracts.rldd.member.create

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.POST

Contract.make {
    description "POST to create member"
    request {
        urlPath "/members"
        method POST
        headers {
            contentType applicationJson()
        }
        body([
            name: 'jinhu.peng'
        ])
    }
    response {
        status 200
        body([
            id   : '004',
            name : 'jinhu.peng',
            point: 3
        ])
    }
}

