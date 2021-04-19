package com.baseproject.androidapp.cache

import com.baseproject.androidapp.cache.mapper.UserModelMapper
import com.baseproject.androidapp.cache.model.UserModel
import com.baseproject.androidapp.data.model.UserEntity
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.Before
import org.junit.Test

class UserModelMapperTest {

    private lateinit var userModelMapper: UserModelMapper

    @Before
    fun setUp() {
        userModelMapper = UserModelMapper()
    }

    @Test
    fun `map user model to user entity`() {

        val userModel = userModelMapper.map(userModelFake())
        SoftAssertions.assertSoftly {
            assertThat(userModel.id).isEqualTo(userEntityFake().id)
            assertThat(userModel.name).isEqualTo(userEntityFake().name)
            assertThat(userModel.lastName).isEqualTo(userEntityFake().lastName)
            assertThat(userModel.avatar).isEqualTo(userEntityFake().avatar)
        }
    }

    private fun userEntityFake() = UserEntity(1L, "Douglas", "Mesquita", "URL")

    private fun userModelFake() = UserModel(1L, "Douglas", "Mesquita", "URL")
}