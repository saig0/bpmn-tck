package io.zeebe.bpmn.tck

import io.zeebe.bpmnspec.junit.BpmnSpecRunner
import io.zeebe.bpmnspec.junit.BpmnSpecSource
import io.zeebe.bpmnspec.junit.BpmnSpecTestCase
import io.zeebe.bpmnspec.junit.SpecRunnerFactory
import io.zeebe.bpmnspec.runner.zeebe.ZeebeTestRunner
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest

@BpmnSpecRunner
class BpmnTest(factory: SpecRunnerFactory) {

    private val specRunner = factory.create(testRunner = ZeebeTestRunner())

    @ParameterizedTest
    @BpmnSpecSource(specResource = "exclusive-gateway-spec.yaml")
    fun `exclusive gateway`(spec: BpmnSpecTestCase) {

        val testResult = specRunner.runSingleTestCase(resources = spec.resources, testcase = spec.testCase)

        Assertions.assertThat(testResult.success)
                .describedAs(testResult.message)
                .isTrue()
    }

    @ParameterizedTest
    @BpmnSpecSource(specResource = "boundary-event-spec.yaml")
    fun `boundary event`(spec: BpmnSpecTestCase) {

        val testResult = specRunner.runSingleTestCase(resources = spec.resources, testcase = spec.testCase)

        Assertions.assertThat(testResult.success)
                .describedAs(testResult.message)
                .isTrue()
    }

}