package com.ecowater.app.model

import androidx.annotation.DrawableRes
import com.ecowater.app.R
import com.google.android.gms.maps.model.LatLng

data class Location(
    val id: String,
    val name: String,
    val description: String,
    val aquaQuality: AquaQuality,
    val city: String,
    val state: String,
    val country: String,
    val endangeredSpecies: List<EndangeredSpecie>,
    val tags: List<String> = emptyList(),
    val coordinates: LatLng,
    @DrawableRes val markerResId: Int
) {

    val firstNamePart get() = name.substringBeforeLast(" ")
    val lastNamePart get() = name.substringAfterLast(" ")

    companion object {
        val sample = listOf(
            Location(
                id = "1",
                name = "Sergipe River",
                description = "A 210 km river that originates in Nossa Senhora da Glória, Sergipe, and flows into the Atlantic Ocean in Aracaju.",
                city = "Aracaju",
                state = "Sergipe",
                country = "Brasil",
                aquaQuality = AquaQuality(
                    ph = 7.5f,
                    temperature = 28f,
                    turbidity = 0.5f,
                    salinity = 0.5f,
                    drinkable = true
                ),
                endangeredSpecies = listOf(
                    EndangeredSpecie(
                        name = "Carpa",
                        scientificName = "Cyprinus carpio",
                        description = "The carp is a freshwater fish that is characterized by its colorful appearance and shiny scales. Common in lakes and rivers of many regions, the carp is appreciated for both its beauty and its ability to grow and reproduce quickly.",
                        imageUrl = "https://portalvidalivre.com/uploads/content/image/3381/peixe_bagre_H2_2.png",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "overfishing", "degradation of its natural habitat"
                        ),
                        protectiveMeasures = listOf("fishing control", "habitat protection"),
                        system = "freshwater"
                    ),
                    EndangeredSpecie(
                        name = "Boto Cinza",
                        scientificName = "Sotalia guianensis",
                        description = "O boto cinza, também conhecido como tucuxi, é um cetáceo da família Delphinidae que vive em águas costeiras da América do Sul. É um dos menores golfinhos do mundo, com comprimento máximo de 2 metros e peso de 80 quilos.O boto cinza tem corpo robusto, com cabeça pequena e focinho estreito. A coloração é cinza escura no dorso e mais clara no ventre. Os machos têm um tufo de pelos na testa.",
                        imageUrl = "https://i.pinimg.com/736x/d2/02/9d/d2029d30438f86b0f88c6fbdda2962dd.jpg",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "Fishing", "harvesting aquatic resources"
                        ),
                        protectiveMeasures = listOf(
                            "Habitat & natural process restoration", "Site/area protection"
                        ),
                        system = "Fresh water"
                    ),
                    EndangeredSpecie(
                        name = "Camarão Pitu",
                        scientificName = "Macrobrachium carcinus",
                        description = "The pitu is the largest native freshwater shrimp in Brazil, reaching up to 50 cm in length and weighing more than 300g. It has a smooth body and large claws.",
                        imageUrl = "https://i0.wp.com/oeco.org.br/wp-content/uploads/2013/05/animalsemana-pitu-destawue.jpg?w=1152&ssl=1",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "overfishing", "degradation of its natural habitat"
                        ),
                        protectiveMeasures = listOf(
                            "river restocking actions"
                        ),
                        system = "Fresh water"
                    )
                ),
                tags = listOf(
                    "Permitted Fishing", "Unfit Bathing", "Environmental Protection"
                ),
                coordinates = LatLng(
                    -10.9110628311829,
                    -37.04779956074638
                ),
                markerResId = R.drawable.sergipe_river_marker
            ),
            Location(
                id = "2",
                name = "Poxim River",
                description = "A 110 km river that originates in the Serra dos Cajueiros and flows into the Atlantic Ocean in Aracaju. It is an important water resource for the region.",
                city = "Aracaju",
                state = "Sergipe",
                country = "Brasil",
                aquaQuality = AquaQuality(
                    ph = 7.5f,
                    temperature = 28f,
                    turbidity = 0.5f,
                    salinity = 0.5f,
                    drinkable = true
                ),
                endangeredSpecies = listOf(
                    EndangeredSpecie(
                        name = "Carpa",
                        scientificName = "Cyprinus carpio",
                        description = "The carp is a freshwater fish that is characterized by its colorful appearance and shiny scales. Common in lakes and rivers of many regions, the carp is appreciated for both its beauty and its ability to grow and reproduce quickly.",
                        imageUrl = "https://portalvidalivre.com/uploads/content/image/3381/peixe_bagre_H2_2.png",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "overfishing", "degradation of its natural habitat"
                        ),
                        protectiveMeasures = listOf("fishing control", "habitat protection"),
                        system = "Fresh water"
                    ),
                    EndangeredSpecie(
                        name = "Boto Cinza",
                        scientificName = "Sotalia guianensis",
                        description = "O boto cinza, também conhecido como tucuxi, é um cetáceo da família Delphinidae que vive em águas costeiras da América do Sul. É um dos menores golfinhos do mundo, com comprimento máximo de 2 metros e peso de 80 quilos.O boto cinza tem corpo robusto, com cabeça pequena e focinho estreito. A coloração é cinza escura no dorso e mais clara no ventre. Os machos têm um tufo de pelos na testa.",
                        imageUrl = "https://i.pinimg.com/736x/d2/02/9d/d2029d30438f86b0f88c6fbdda2962dd.jpg",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "Fishing", "harvesting aquatic resources"
                        ),
                        protectiveMeasures = listOf(
                            "Habitat & natural process restoration", "Site/area protection"
                        ),
                        system = "Fresh water"
                    ),
                    EndangeredSpecie(
                        name = "Camarão Pitu",
                        scientificName = "Macrobrachium carcinus",
                        description = "The pitu is the largest native freshwater shrimp in Brazil, reaching up to 50 cm in length and weighing more than 300g. It has a smooth body and large claws.",
                        imageUrl = "https://i0.wp.com/oeco.org.br/wp-content/uploads/2013/05/animalsemana-pitu-destawue.jpg?w=1152&ssl=1",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "overfishing", "degradation of its natural habitat"
                        ),
                        protectiveMeasures = listOf(
                            "river restocking actions"
                        ),
                        system = "Fresh water"
                    )
                ),
                tags = listOf(
                    "Permitted Fishing", "Unfit Bathing", "Environmental Protection"
                ),
                coordinates = LatLng(
                    -10.966365497500895,
                    -37.04610493851265
                ),
                markerResId = R.drawable.poxim_river_marker
            ), Location(
                id = "3",
                name = "Atalaia Beach",
                description = "Atalaia Beach is a popular beach in Aracaju, Brazil. It is known for its white sand, clear waters, and coconut palms. The beach is a great place to relax, swim, sunbathe, and explore.",
                city = "Aracaju",
                state = "Sergipe",
                country = "Brasil",
                aquaQuality = AquaQuality(
                    ph = 7.5f,
                    temperature = 28f,
                    turbidity = 0.5f,
                    salinity = 0.5f,
                    drinkable = true
                ),
                endangeredSpecies = listOf(
                    EndangeredSpecie(
                        name = "Baleia-cachalote",
                        scientificName = "Physeter macrocephalus",
                        description = "The sperm whale is the largest toothed predator in the world, reaching up to 20 meters in length and 50 tons in weight. It is found in all oceans, except the Arctic. Sperm whales are carnivores, feeding on a variety of prey, including squid, fish, and sharks. They are an important part of marine ecosystems.",
                        imageUrl = "https://ciencianautas.com/wp-content/uploads/2021/08/Sem-Titulo-1-3.png",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "bycath", "entanglement", "noise pollution"
                        ),
                        protectiveMeasures = listOf("bycatch reduction", "marine debris reduction", "noise pollution mitigation"),
                        system = "marine"
                    ),
                    EndangeredSpecie(
                        name = "Tartaruga-oliva",
                        scientificName = "Lepidochelys olivacea",
                        description = "The olive ridley sea turtle is a small sea turtle species, reaching up to 70 centimeters in length and 40 kilograms in weight. It is found in tropical and subtropical oceans around the world. Olive ridley sea turtles are herbivores, feeding on a variety of marine plants. They are an important part of marine ecosystems.",
                        imageUrl = "https://www.tamar.org.br/fotos/S05_A_08.jpg",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "degradation of its natural habitat", "pollution"
                        ),
                        protectiveMeasures = listOf(
                            "protecting nesting habitats", "habitat protection"
                        ),
                        system = "marine"
                    ),
                    EndangeredSpecie(
                        name = "Tartaruga-de-pente",
                        scientificName = "Eretmochelys imbricata",
                        description = "The hawksbill sea turtle is a small to medium-sized sea turtle species, reaching up to 90 centimeters in length and 180 kilograms in weight. It is found in tropical and subtropical oceans around the world. Hawksbill sea turtles are carnivores, feeding on a variety of invertebrates, including sponges, sea urchins, and mollusks. They are an important part of marine ecosystems.",
                        imageUrl = "https://tamar.org.br/fotos/F02_035_1.jpg",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "degradation of its natural habitat", "pollution"
                        ),
                        protectiveMeasures = listOf(
                            "protecting nesting habitats", "habitat protection"
                        ),
                        system = "marine"
                    )
                ),
                tags = listOf(
                    "Permitted Fishing", "Environmental Protection"
                ),
                coordinates = LatLng(
                    -10.978777767969637,
                    -37.03659289817027
                ),
                markerResId = R.drawable.atalaia_beach_marker
            ),
            Location(
                id = "4",
                name = "Formosa Beach",
                description = "Formosa Beach in Aracaju, Sergipe, is a popular 1.5 km stretch known for its clear waters, white sands, and palm trees, attracting both tourists and locals for swimming, sunbathing, and relaxation.",
                city = "Aracaju",
                state = "Sergipe",
                country = "Brasil",
                aquaQuality = AquaQuality(
                    ph = 7.5f,
                    temperature = 28f,
                    turbidity = 0.5f,
                    salinity = 0.5f,
                    drinkable = true
                ),
                endangeredSpecies = listOf(
                    EndangeredSpecie(
                        name = "Tartaruga-cabeçuda",
                        scientificName = "Caretta caretta",
                        description = "The loggerhead sea turtle is a large sea turtle species, reaching up to 1.5 meters in length and weighing up to 300 kilograms. It is found in all tropical and subtropical oceans. Loggerhead sea turtles are omnivores, feeding on a variety of marine animals, including fish, squid, and jellyfish. They are an important part of marine ecosystems.",
                        imageUrl = "https://www.infoescola.com/wp-content/uploads/2013/09/tartaruga-cabe%C3%A7uda_528238666.jpg",
                        alertLevel = AlertLevel.CriticalDanger,
                        principalThreats = listOf(
                            "degradation of its natural habitat", "pollution"
                        ),
                        protectiveMeasures = listOf("Protecting nesting habitats", "habitat protection"),
                        system = "marine"
                    ),
                    EndangeredSpecie(
                        name = "Tartaruga-oliva",
                        scientificName = "Lepidochelys olivacea",
                        description = "The olive ridley sea turtle is a small sea turtle species, reaching up to 70 centimeters in length and 40 kilograms in weight. It is found in tropical and subtropical oceans around the world. Olive ridley sea turtles are herbivores, feeding on a variety of marine plants. They are an important part of marine ecosystems.",
                        imageUrl = "https://www.tamar.org.br/fotos/S05_A_08.jpg",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "degradation of its natural habitat", "pollution"
                        ),
                        protectiveMeasures = listOf(
                            "protecting nesting habitats", "habitat protection"
                        ),
                        system = "marine"
                    ),
                    EndangeredSpecie(
                        name = "Tartaruga-de-pente",
                        scientificName = "Eretmochelys imbricata",
                        description = "The hawksbill sea turtle is a small to medium-sized sea turtle species, reaching up to 90 centimeters in length and 180 kilograms in weight. It is found in tropical and subtropical oceans around the world. Hawksbill sea turtles are carnivores, feeding on a variety of invertebrates, including sponges, sea urchins, and mollusks. They are an important part of marine ecosystems.",
                        imageUrl = "https://tamar.org.br/fotos/F02_035_1.jpg",
                        alertLevel = AlertLevel.Vulnerable,
                        principalThreats = listOf(
                            "degradation of its natural habitat", "pollution"
                        ),
                        protectiveMeasures = listOf(
                            "protecting nesting habitats", "habitat protection"
                        ),
                        system = "marine"
                    )
                ),
                tags = listOf(
                    "Permitted Fishing", "Environmental Protection"
                ),
                coordinates = LatLng(
                    -10.929089841358078,
                    -37.04462471248932
                ),
                markerResId = R.drawable.formosa_beach_marker
            ),
        )
    }
}