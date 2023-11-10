package com.pepito.animal.midterm

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pepito.animal.midterm.databinding.ActivityAnimalNamesBinding


class AnimalNamesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalNamesBinding
    private lateinit var sharedPreferences: SharedPreferences

    // Define animalList as a class-level property
    private val listOfAnimals = mutableListOf<AdapterForAnimalNames.AnimalDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("BlockedAnimals", MODE_PRIVATE)


        // Set up the initial animalList
        listOfAnimals.addAll(listOf(
            AdapterForAnimalNames.AnimalDataModel("Ant", "Ants, incredible social insects, form colonies with specific roles, foraging tirelessly for food and attending to the queen and her offspring. Their teamwork, communication via pheromones, and elaborate underground networks showcase remarkable collective behavior in highly organized communities, playing essential roles in ecosystem processes and nutrient cycling."),
            AdapterForAnimalNames.AnimalDataModel("Bear", "Bears, varying in size and behavior across species, are formidable omnivorous mammals known for hibernating during colder months, relying on stored fat for survival. Their roles in diverse ecosystems, such as seed dispersal and regulating prey populations, are crucial. From the mighty grizzly to the gentle panda, bears' adaptability and importance in ecological systems mark them as significant icons of wilderness conservation."),
            AdapterForAnimalNames.AnimalDataModel("Cheetah", "Cheetahs, the fastest land animals, boast slender bodies and spotted fur aiding in camouflaging during high-speed pursuits. Their incredible sprinting abilities, reaching speeds up to 60 miles per hour in short bursts, make them successful predators in various habitats, demonstrating evolutionary adaptations that secure their place as apex hunters."),
            AdapterForAnimalNames.AnimalDataModel("Dolphin", "Dolphins are highly intelligent marine mammals with streamlined bodies, curved dorsal fins, and a reputation for their playful nature. They communicate through a complex system of clicks, whistles, and body language and are known for their acrobatic displays and strong social bonds within pods."),
            AdapterForAnimalNames.AnimalDataModel("Elephant", "Elephants, known for their iconic trunks, tusks, and impressive memory, exhibit complex social structures within herds. These gentle giants play a crucial role in shaping their ecosystems and demonstrate emotional intelligence and strong familial bonds. Their significant impact on the landscape, from forest clearing to maintaining water sources, underlines their role as keystone species in numerous habitats, necessitating conservation efforts for their survival."),
            AdapterForAnimalNames.AnimalDataModel("Frog", "Frogs, amphibians with the ability to metamorphose, start as aquatic tadpoles before transitioning into adults with powerful hind legs for jumping. Their unique life cycle involves laying eggs in water, where tadpoles develop into adult frogs, making them integral to both aquatic and terrestrial ecosystems. With their sensitive permeable skin and reliance on wet habitats, frogs serve as indicators of environmental health, highlighting the need for freshwater conservation and biodiversity preservation."),
            AdapterForAnimalNames.AnimalDataModel("Giraffe", "Giraffes, the tallest land animals, have long necks that enable them to reach high foliage in their savanna habitats. With distinctive spotted coats, these gentle herbivores display complex social behaviors and play a crucial role in the ecosystems they inhabit. Their specialized physiology, including a unique cardiovascular system and prehensile tongues, reflects their adaptations for surviving and thriving in their African habitats."),
            AdapterForAnimalNames.AnimalDataModel("Hammerhead shark", " Hammerhead sharks are distinctive for their flattened, T-shaped heads. These sharks are found in various oceans and are known for their acute sense of smell and the ability to detect prey hidden beneath the sand."),
            AdapterForAnimalNames.AnimalDataModel("Iguana", "Iguanas, large herbivorous lizards found in tropical regions, possess distinctive dewlaps and tails, contributing to their camouflage and communication. These reptiles regulate body temperature through basking and are essential components of their ecosystems. With their vital roles as herbivores and seed dispersers, iguanas influence the dynamics and vegetation patterns in their habitats, underlining their importance in preserving biodiversity."),
            AdapterForAnimalNames.AnimalDataModel("Jaguar", "Jaguars, large spotted cats, are apex predators in their environments, displaying strength and agility. Their distinctive rosette-patterned fur aids in camouflage during hunting, and their elusive nature contributes to their role in maintaining ecological balance. With shrinking habitats and the pressures of human encroachment, conservation efforts play a vital role in securing their survival and safeguarding the biodiversity of their habitats."),
            AdapterForAnimalNames.AnimalDataModel("Kangaroo", "Kangaroos, iconic marsupials, use their powerful hind legs to hop and carry their young in pouches. These herbivores play a significant role in their ecosystems, and their adaptability to various Australian habitats is essential to the region's biodiversity. As symbols of Australia and its unique wildlife, kangaroos signify the delicate balance between conservation efforts and the coexistence of human populations and natural landscapes."),
            AdapterForAnimalNames.AnimalDataModel("Lion", " Lions, iconic social cats, form prides where females are primary hunters, displaying powerful roars and majestic appearances. These apex predators play a crucial role in regulating prey populations in their African habitats. Lions' conservation has far-reaching implications for maintaining the delicate equilibrium of ecosystems, highlighting the need to address habitat loss and human-wildlife conflict."),
            AdapterForAnimalNames.AnimalDataModel("Moose", "Moose, solitary herbivores with broad antlers, are vital components of northern forest ecosystems. Their adaptations to cold climates and unique antler structures contribute to their role in shaping their habitats. As large herbivores, moose play a crucial role in nutrient cycling and seed dispersal, emphasizing their significance in the sustainability of arboreal ecosystems."),
            AdapterForAnimalNames.AnimalDataModel("Nightingale", " Nightingales, small songbirds, are known for their melodious calls and are often associated with the night. Their enchanting songs are part of their courtship displays and have inspired folklore and poetry for centuries. Nightingales' migratory habits and harmonious melodies contribute to the cultural and natural heritage, underscoring the importance of preserving their habitats and migration corridors."),
            AdapterForAnimalNames.AnimalDataModel("Ostrich", " Ostriches, the largest living birds, are flightless and possess powerful legs, enabling impressive running speeds. Found in arid and semi-arid environments, they play a critical role in their ecosystems. As prominent species in African savannas, ostriches demonstrate the coexistence of unique adaptations and the need for conservation in arid landscapes."),
            AdapterForAnimalNames.AnimalDataModel("Penguin", " Penguins, flightless birds living in the Southern Hemisphere, have unique tuxedo-like appearances and excel in swimming. Their group behavior and adaptations to extreme cold environments are essential to their survival. With diverse species inhabiting various environments, penguins illustrate the resilience and diversity of life in some of the most extreme conditions on Earth."),
            AdapterForAnimalNames.AnimalDataModel("Quail", "Quails, small ground-dwelling birds, are known for their distinctive calls and ground foraging behavior. They are popular game birds and contribute to the biodiversity of various habitats. As both wildlife and sources of recreation, quails emphasize the need for sustainable hunting practices and habitat conservation to maintain healthy populations in natural landscapes."),
            AdapterForAnimalNames.AnimalDataModel("Raccoon", " Raccoons, small nocturnal mammals with distinctive masked faces, are adaptable omnivores often found near water sources. Their dexterous front paws and climbing abilities contribute to their foraging and survival in urban and natural settings. Raccoons' adaptability and presence in various environments underscore the need for coexistence strategies and wildlife management in shared habitats."),
            AdapterForAnimalNames.AnimalDataModel("Shark", "Sharks, diverse predatory fish with cartilaginous skeletons, play a vital role as apex predators in ocean ecosystems. Their influence in marine food webs and their adaptability to various habitats highlight their significance in regulating and maintaining oceanic biodiversity. Conservation efforts aimed at protecting sharks emphasize the interconnectedness of marine life and the preservation of delicate oceanic balances."),
            AdapterForAnimalNames.AnimalDataModel("Tiger", " Tigers, powerful striped cats, are apex predators with a significant role in their habitats. Their strength and agility make them effective hunters, contributing to the balance of various ecosystems. With dwindling populations and threats to their habitats, tiger conservation remains a critical issue in preserving biodiversity and restoring ecological harmony."),
            AdapterForAnimalNames.AnimalDataModel("Umbrella bird", "Umbrella birds, large birds with distinctive crests, are found in the rainforests of Central and South America. Their unique appearances and behaviors contribute to the biodiversity of these lush ecosystems. As ambassadors of forest conservation, protecting umbrella bird habitats becomes crucial in preserving the richness of neotropical rainforests."),
            AdapterForAnimalNames.AnimalDataModel("Vampire squid", "Vampire squid are deep-sea cephalopods known for their unique appearance. They are not true squids but have characteristics of both squid and octopuses. They inhabit the dark depths of the ocean and are well adapted to extreme pressure and low oxygen levels."),
            AdapterForAnimalNames.AnimalDataModel("Walrus", "Walruses are large marine mammals with distinctive tusks and a blubbery body. They are known for their social behavior, tusk use in various activities, and being adapted to life in the Arctic."),
            AdapterForAnimalNames.AnimalDataModel("Xerus", "Xerus, commonly known as African ground squirrels, are small rodents found in African habitats, known for their burrowing behavior and bushy tails. They contribute to the ecology of their habitats by influencing soil structure and plant distribution. Their role as ecosystem engineers highlights the need for understanding the significance of small mammals in shaping savanna ecosystems."),
            AdapterForAnimalNames.AnimalDataModel("Yak", "Yaks, domesticated cattle adapted to high-altitude environments, play a crucial role in Himalayan communities. Their strength, fur, and resilience make them vital assets for the local economy and ecosystem. As essential livestock for the livelihoods of mountain communities, yak conservation and sustainable management practices become pivotal for the delicate Himalayan ecosystems."),
            AdapterForAnimalNames.AnimalDataModel("Zebra", "Zebras, herbivorous equids with distinctive black-and-white stripes, live in social groups. Their presence and behavior contribute to the dynamics of the grassland ecosystems they inhabit. As essential components of African savannas, zebras showcase the interconnectedness of species and the necessity for protecting their habitats and migratory routes for preserving biodiversity."),



            ))

        val adapter = AdapterForAnimalNames(listOfAnimals, ::onItemClick)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@AnimalNamesActivity)
            addItemDecoration(DividerItemDecoration(this@AnimalNamesActivity, LinearLayoutManager.HORIZONTAL))
            this.adapter = adapter
        }

        // Set up the "Manage Block Animals" button click listener
        binding.manageBlockAnimalsB.setOnClickListener {
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh the animal list based on the current block status
        refreshAnimalList()
    }

    private fun onItemClick(item: AdapterForAnimalNames.AnimalDataModel) {
        // Handle the item click here
        val intent = Intent(this, AnimalDetailsActivity::class.java).apply {
            putExtra("NAME_PARAMS", item.name)
            putExtra("DESCRIPTION_PARAMS", item.description)
        }
        startActivity(intent)
    }

    private fun refreshAnimalList() {
        val blockedAnimals = getBlockedAnimals()
        val filteredAnimalList = listOfAnimals.filter { animal ->
            animal.name !in blockedAnimals
        }

        val adapter = AdapterForAnimalNames(filteredAnimalList, ::onItemClick)
        binding.recyclerView.adapter = adapter
    }

    private fun getBlockedAnimals(): Set<String> {
        // Retrieve the set of blocked animals from SharedPreferences
        return sharedPreferences.getStringSet("blocked_animals", setOf()) ?: setOf()
    }
}
