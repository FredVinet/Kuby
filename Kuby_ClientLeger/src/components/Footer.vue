<template >
    <div class="bg-info mt-10 h-100" >
        <div class="pt-16 d-flex justify-center">
            <button style="background: none; border: none; padding: 0;" @click="navigateTo('/')">
                <img src="../assets/images/Logo2.png" class="mt-15" style="width: 15vw; height: auto; cursor: pointer;">
            </button>   
        </div>
        <v-row>
            <v-col class="d-flex justify-center mt-5">

                <v-btn variant="plain" class="me-10" @click="navigateTo('/')">A Propos</v-btn>
                <v-btn variant="plain" class="me-10" @click="navigateTo('/')">Questions Fréquentes</v-btn>
                <v-btn variant="plain" class="me-10" @click="navigateTo('/')">Contact</v-btn>

            </v-col>
            <v-col class="d-flex justify-center mt-5">

                <v-btn variant="plain" class="me-10" @click="navigateTo('/')">CGV</v-btn>
                <v-btn variant="plain" class="me-10" @click="navigateTo('/')">Mention Légales</v-btn>
                <v-btn variant="plain" class="me-10" @click="navigateTo('/')">Données Personelles</v-btn>

            </v-col>
        </v-row>
        <div class="pt-16 d-flex justify-center">
            <img src="../assets/images/AlcoolRule.png" class="mt-5" style="width: 60vw; height: auto;">
        </div>

        <div class="pt-16 text-center">
            <h2 class="">L'ABUS D'ALCOOL EST DANGEREUX POUR LA SANTÉ. À CONSOMMER AVEC MODÉRATION.</h2>
            <h4 class="pt-10" >
                Conformément à la loi " Informatique et Libertés du 06.01.1978 modifiée, ainsi qu'au règlement européen relatif à la protection des <br>
                données (RGPD), vous pouvez faire valoir vos droits d'accès aux données, de rectification, d'effacement, <br> 
                de portabilité de transmissions en cas de décès, de limitation du traitement ainsi que vous opposer au traitement en formulant votre demande.<br> 
                Pour en savoir plus cliquez ici.
            </h4>
        </div>

    </div> 

</template>
    
    <script setup>
    
    import { useRouter } from 'vue-router';
    import { ref } from 'vue';
    
    const router = useRouter();
    
    function navigateTo(path) {
        router.push(path);
    }
    
    
    </script>