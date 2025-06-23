//package Kafka;
//
//@RestController
//public class GetPatient {
//
//    PatientService patientService;
//
//    public GetPatient(PatientService patientService) {
//        patientService = patientService;
//    }
//
//    @GetMapping("/v1/getPatient/{patientId}")
//    public ResponseEntity<Patient>  getPatient(@PathParam String patientId) {
//        Patient patient = patientService.getPatient(patientId);
//        return ResponseEntity.ok(patient);
//    }
//}
