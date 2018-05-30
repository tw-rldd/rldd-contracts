package contracts.rldd.member.point.restore

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.POST

Contract.make {
    description "POST to restore point to 3"
    request {
        urlPath "/members/002/restorePoint"
        method POST
    }
    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
            id   : '002',
            name : 'yugang.zhou',
            point: 3
        ])
    }
}

